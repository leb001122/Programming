public class Person {

    private int id;
    private String name;
    private String phoneNum;
    private String college;
    private String address;

    public Person(int id, String name, String phoneNum, String college, String address) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.college = college;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNum() { return phoneNum; }
    public String getCollege() { return college; }
    public String getAddress() { return address; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
    public void setCollege(String college) { this.college = college; }
    public void setAddress(String address) { this.address = address; }

    public String toStirng() {
        return id+", "+name+", "+phoneNum+", "+college+", "+address;
    }
}
