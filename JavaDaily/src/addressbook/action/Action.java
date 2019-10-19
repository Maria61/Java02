package addressbook.action;

import addressbook.classes.Address;
import addressbook.datebase.AddressBook;
import addressbook.exception.NoPersonException;
import addressbook.exception.NoTelephoneException;

import java.util.List;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/19 9:56
 */
public class Action {

    /**
     * 添加通讯
     */
    public static void insert(String name, String note, String telephone) {
        AddressBook addressBook = AddressBook.getInstance();
        Address address = new Address(note, telephone);
        addressBook.insert(name, address);
    }

    /**
     * 通过姓名查找
     */
    public static List select(String name) throws NoTelephoneException, NoPersonException {
        AddressBook addressBook = AddressBook.getInstance();
        List addresses = null;
        addresses = addressBook.select(name);

        return addresses;
    }

    /**
     * 删除联系人
     */
    public static void delete(String name) throws NoPersonException {
        AddressBook addressBook = AddressBook.getInstance();
        addressBook.delete(name);

    }

    /**
     * 删除联系人的某个联系方式
     */
    public static void deleteTelephone(String name, String telephone) {
        AddressBook addressBook = AddressBook.getInstance();
        try {
            addressBook.deleteTelephone(name, telephone);
        } catch (NoPersonException e) {
            System.out.println("查无此人，删除失败");
        }
    }

}
