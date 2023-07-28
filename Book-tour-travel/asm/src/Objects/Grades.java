
package Objects;

import java.util.Objects;

/**
 *
 * @author kieu anh văn
 */
public class Grades {
    private String id;
    private String name;
    private float Englist;
    private float TinHoc;
    private float GDTC;

    public Grades() {
    }

    public Grades(String id, String name, float Englist, float TinHoc, float GDTC) {
        this.id = id;
        this.name = name;
        this.Englist = Englist;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getEnglist() {
        return Englist;
    }

    public void setEnglist(float Englist) {
        this.Englist = Englist;
    }

    public float getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(float TinHoc) {
        this.TinHoc = TinHoc;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Grades other = (Grades) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
}
