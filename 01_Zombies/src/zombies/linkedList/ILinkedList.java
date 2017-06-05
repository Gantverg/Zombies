package zombies.linkedList;

public interface ILinkedList<E> extends Iterable<E> {
	boolean hasPrev();

	E prev();

	E remove();

	void add(E e);

	void set(E e);
}
