package interfaces;

public interface IteratorInterface
{
    public void previous();
    public void next();
    public void first();
    public void last();
    public boolean isDone();
    public Object current();
}