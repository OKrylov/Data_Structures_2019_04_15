import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.datastructures.queue.Queue;
import ru.geekbrains.datastructures.queue.QueueImpl;
import ru.geekbrains.datastructures.queue.QueueOverloadException;
import ru.geekbrains.datastructures.stack.Stack;
import ru.geekbrains.datastructures.stack.StackImpl;
import ru.geekbrains.datastructures.stack.StackOverloadException;

public class QueueTestCase {

    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueImpl<>(5);
    }

    @Test
    public void test_create_queue() {
        Assertions.assertNotNull(queue);
    }

    @Test
    public void test_add_to_queue() {
        queue.insert(1);
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    public void test_add_element_to_full_queue() {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        Assertions.assertThrows(QueueOverloadException.class, () -> {
            queue.insert(6);
        });
    }

    @Test
    public void test_remove() {
        queue.insert(1);
        Assertions.assertEquals(1, queue.remove());
        Assertions.assertEquals(0, queue.getSize());
        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertFalse(queue.isFull());
    }

    @Test
    public void test_display() {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            sb.append(queue.remove());
        }

        Assertions.assertEquals("12345", sb.toString());
    }


}
