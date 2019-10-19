package library_management_system.database;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/16 23:48
 */
public interface Where<E> {
    boolean test(E e);
}
