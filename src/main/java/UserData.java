import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    private Integer id;
    private String first_name;

    public UserData() {
    }

    public UserData(Integer id, String first_name) {
        this.id = id;
        this.first_name = first_name;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                '}';
    }
}
