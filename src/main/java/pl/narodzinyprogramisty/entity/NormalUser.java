package pl.narodzinyprogramisty.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "normal_users")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "normal_user_id"))})
public class NormalUser extends BaseModel {

    public static final String TABLE_NAME = "NormalUser";

    @Embedded
    private User user;

    @Column(name = "address")
    private String address;

    @OneToMany
    private List<Ad> adList;

    public NormalUser() {
    }

    public NormalUser(User user, String address, List<Ad> adList) {
        this.user = user;
        this.address = address;
        this.adList = adList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Ad> getAdList() {
        return adList;
    }

    public void setAdList(List<Ad> adList) {
        this.adList = adList;
    }

    @Override
    public String toString() {
        return "NormalUser{" +
                "user=" + user +
                ", address='" + address + '\'' +
                ", adList=" + adList +
                '}';
    }
}
