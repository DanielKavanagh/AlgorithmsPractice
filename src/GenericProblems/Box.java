package GenericProblems;

public class Box<T> {
    private T inside;

    public Box(T inside) {
        this.inside = inside;
    }

    public Box() {}

    public void set(T value) {
        inside = value;
    }

    public T get() {
        return inside;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{value=" + inside + "}";
    }
}
