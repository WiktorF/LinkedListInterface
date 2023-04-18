package iterators;

import interfaces.IteratorInterface;
import lists.LinkedList;

public class LinkedListIterator implements IteratorInterface
{
    private LinkedList list;
    private LinkedList.Node current;

    public LinkedListIterator(LinkedList l)
    {
        list = l;
        current = null;
    }

    @Override
    public void previous()
    {
      Object stop = current;
      current = list.getFirst();
      while(current.next != stop){
          current = current.next;
      }
    }

    @Override
    public void next()
    {
        current = current.next;
    }

    @Override
    public void first()
    {
        current = list.getFirst();
    }

    @Override
    public void last()
    {
        current = list.getLast();
    }

    @Override
    public boolean isDone() {
        return current == null;
    }

    @Override
    public Object current() {
        return current.value;
    }
}
