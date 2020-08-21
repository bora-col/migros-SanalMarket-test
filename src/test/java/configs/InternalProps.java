package configs;

public class InternalProps extends AbstractProps
{
    private String username;
    private String password;
    private String phoneNumber;


    public InternalProps()
    {
        loadConfigProperties("internal_config.properties");

        setUsername(this.username = configProps.getProperty("user.name"));
        setPassword(this.password = configProps.getProperty("user.password"));
        setPhoneNumber(this.phoneNumber = configProps.getProperty("user.phoneNumber"));
    }

    //Getters and Setters

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
