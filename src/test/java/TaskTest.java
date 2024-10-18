import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TaskTest {
    public static void main(String[] args) {

    }

    @Test
    void TestTask(){
        Task temp = new Task("Hello");
        temp.markProgress();
        String json = temp.getJSON();
        Task result = Task.fromJSON(json);
        org.junit.jupiter.api.Assertions.assertAll(
            "Task temp:",()-> Assertions.assertEquals(temp.getId(),result.getId()),
                ()->Assertions.assertEquals(temp.getDescription(),result.getDescription()),
                ()->Assertions.assertEquals(temp.getStatus(),result.getStatus())
        );
    }

}
