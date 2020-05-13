import java.io.Serializable;

/**
 * @author Maria
 * @program homework05
 * @date 2020/5/13 14:18
 */
@SuppressWarnings("serial")
public class CustomerBean implements Serializable {

    private  String custName;
    private String email;
    private String phone;
    public CustomerBean() {}
    public CustomerBean(String custName,String email,String phone)
    {
        this.custName=custName;
        this.email=email;
        this.phone=phone;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
