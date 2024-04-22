import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TheSearchInSimpleTaskIsTrue() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");


        Boolean expected = true;
        Boolean actual = task.matches("Позвонить родителям");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TheSearchInSimpleTaskIsFalse() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");


        Boolean expected = false;
        Boolean actual = task.matches("Прийти к родителям");

        Assertions.assertEquals(expected, actual);
    }




    @Test
    public void TheSearchInEpicIsTrue() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic task = new Epic(55, subtasks);


        Boolean expected = true;
        Boolean actual = task.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TheSearchInEpicIsFalse() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic task = new Epic(55, subtasks);


        Boolean expected = false;
        Boolean actual = task.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }




    @Test
    public void TheSearchInMeetingIsTrue() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        Boolean expected = true;
        Boolean actual = task.matches("Выкатка 3й версии приложения");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TheSearchInMeetingIsTrueTrue() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        Boolean expected = true;
        Boolean actual = task.matches("Приложение НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TheSearchInMeetingIsFalse() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        Boolean expected = false;
        Boolean actual = task.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }
}
