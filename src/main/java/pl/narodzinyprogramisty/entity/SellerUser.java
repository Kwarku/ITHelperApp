package pl.narodzinyprogramisty.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seller_users")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "seller_user_id"))})
public class SellerUser extends BaseModel {

    public static final String TABLE_NAME = "SellerUser";

    @Embedded
    private User user;

    @Column(name= "academy")
    private String academy;

    @Column(name = "tier")
    private int tier;

    @OneToOne
    private Ad workingAd;

    @OneToMany
    private List<Ad> doneAdList;

    public SellerUser() {
    }

    public SellerUser(User user, String academy, int tier, Ad workingAd, List<Ad> doneAdList) {
        this.user = user;
        this.academy = academy;
        this.tier = tier;
        this.workingAd = workingAd;
        this.doneAdList = doneAdList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public Ad getWorkingAd() {
        return workingAd;
    }

    public void setWorkingAd(Ad workingAd) {
        this.workingAd = workingAd;
    }

    public List<Ad> getDoneAdList() {
        return doneAdList;
    }

    public void setDoneAdList(List<Ad> doneAdList) {
        this.doneAdList = doneAdList;
    }

    @Override
    public String toString() {
        return "SellerUser{" +
                "user=" + user +
                ", academy='" + academy + '\'' +
                ", tier=" + tier +
                ", workingAd=" + workingAd +
                ", doneAdList=" + doneAdList +
                '}';
    }
}
