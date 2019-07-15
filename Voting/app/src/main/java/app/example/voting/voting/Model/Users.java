package app.example.voting.voting.Model;

public class Users {
    private String Email ;
    private String  Phone ;
    private int Image ;


    public Users() {
    }

    public Users(int image, String email, String phone) {

        Email = email;
        Phone = phone;
        Image = image ;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
