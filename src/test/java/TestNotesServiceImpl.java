import org.example.Note;
import org.example.NotesServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.example.NotesServiceImpl.createWith;
import static org.junit.jupiter.api.Assertions.*;

public class TestNotesServiceImpl {
    Note noteOne = new Note("first", 1.0f);
    Note noteTwo = new Note("second", 2.0f);
    Note secondNoteOne = new Note("first", 3.0f);
    MockedNotesStorage storage = new MockedNotesStorage();
    NotesServiceImpl service = createWith(storage);

    @AfterEach
    public void clear() {
        storage.clear();
    }


    @Test
    public void testClear() {
        service.add(noteOne);
        service.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void testAddToStorage(){
        service.add(noteOne);
        assertTrue(storage.getAllNotesOf("first").contains(noteOne));
    }

    @Test
    public void testAddTwoToStorage(){
        service.add(noteOne);
        service.add(secondNoteOne);
        assertEquals(2, storage.getAllNotesOf("first").size());
    }

    @Test
    public void testAddTwoDifferentToStorage(){
        service.add(noteOne);
        service.add(noteTwo);
        assertEquals(1, storage.getAllNotesOf("first").size());
    }

    @Test
    public void testCheckAverage(){
        service.add(noteOne);
        service.add(secondNoteOne);
        assertEquals(2.0f, service.averageOf("first"));
    }
}
