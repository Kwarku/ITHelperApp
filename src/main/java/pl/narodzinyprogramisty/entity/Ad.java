package pl.narodzinyprogramisty.entity;

import javax.persistence.*;

@Entity
@Table(name = "ads")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "ad_id"))})
public class Ad extends BaseModel {

    public static final String TABLE_NAME = "Ad";

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String desc;

    @Column(name = "ad_type")
    private String adType;

    @Column(name = "address")
    private String address;

    public Ad() {
    }

    public Ad(String title, String desc, String adType, String address) {
        this.title = title;
        this.desc = desc;
        this.adType = adType;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", adType='" + adType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
