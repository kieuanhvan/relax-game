
package Objects;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author kieu anh văn
 */
public class User {
    private String FullName;
    private String Password;
    private String role;
    private String gmail;
    private String gender;
    private Date birthday;
    public User() {
    }

    public User(String FullName, String Password, String role) {
        this.FullName = FullName;
        this.Password = Password;
        this.role = role;
    }

    public User(String FullName, String Password, String role, String gmail, String gender, Date birthday) {
        this.FullName = FullName;
        this.Password = Password;
        this.role = role;
        this.gmail = gmail;
        this.gender = gender;
        this.birthday = birthday;
    }
    

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.FullName);
        hash = 79 * hash + Objects.hashCode(this.Password);
        hash = 79 * hash + Objects.hashCode(this.role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.FullName, other.FullName)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        return Objects.equals(this.role, other.role);
    }

    @Override
    public String toString() {
        return "User{" + "FullName=" + FullName + ", Password=" + Password + ", role=" + role + ", gmail=" + gmail + ", gender=" + gender + ", birthday=" + birthday + '}';
    }

   

    
}
