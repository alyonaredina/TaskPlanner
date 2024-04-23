import java.util.Objects;

public abstract class Task {
    protected int id;


    public Task(int id) {

        this.id = id;
    }

    public int getId() {

        return id;
    }


    // Ниже находятся вспомогательные методы для корректной работы equals
    // Переопределять их в наследниках не нужно

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Task task = (Task) o;
            result = id == task.id;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    /**
     * Метод, проверяющий подходит ли эта задача поисковому запросу.
     * Эта логика должна быть определена в наследниках, у каждого она будет своя
     * @param query Поисковый запрос
     * @return Ответ на вопрос, подходит ли эта задача под поисковый запрос
     */
    public boolean matches(String query) {
        return false;
    }




}

