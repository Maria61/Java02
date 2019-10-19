package addressbook.datebase;

import addressbook.classes.Address;
import addressbook.exception.NoPersonException;
import addressbook.exception.NoTelephoneException;

import java.util.List;
import java.util.TreeMap;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/19 9:51
 */
public class AddressBook {
    private TreeMap<String, List<Address>> addressBook = new TreeMap<>();
    private static AddressBook instance = new AddressBook();

    public static AddressBook getInstance() {
        return instance;
    }

    public void insert(String name, Address address) {
        List addresses = addressBook.get(name);
        addresses.add(address);
        addressBook.put(name, addresses);
    }

    public List select(String name) throws NoPersonException, NoTelephoneException {
        if (addressBook.containsKey(name)) {
            List addresses = addressBook.get(name);
            if (addresses == null) {
                throw new NoTelephoneException();
            }
            return addresses;
        } else {
            throw new NoPersonException();
        }
    }

    public void delete(String name) throws NoPersonException {
        if (addressBook.containsKey(name)) {
            addressBook.remove(name);
        } else {
            throw new NoPersonException();
        }
    }

    public void deleteTelephone(String name, String telephone) throws NoPersonException {
        if (addressBook.containsKey(name)) {
            List addresses = addressBook.get(name);
            addresses.remove(telephone);
        } else {
            throw new NoPersonException();
        }
    }
}
