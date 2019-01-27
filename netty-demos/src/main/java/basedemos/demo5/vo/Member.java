package basedemos.demo5.vo;

import java.io.Serializable;
import java.util.UUID;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-27 16:51
 **/
public class Member implements Serializable {

    private long id;
    private String name;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Member buildRandom() {
        Member member = new Member();
        member.setId((long) Math.random() * 100);
        member.setName("wang" + UUID.randomUUID().toString().substring(0, 5));
        member.setEmail("test@Email" + UUID.randomUUID().toString().substring(0, 5));
        return member;
    }
}
