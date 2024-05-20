package it.src.exercises.esercizi_intermedi;

public class Ex08PhoneCall {
    private String  telephoneNumberCalled;
    private int     phoneCallTime;

    public Ex08PhoneCall() {}
    public Ex08PhoneCall(String telephoneNumberCalled, int phoneCallTime)
    {
        this.telephoneNumberCalled = telephoneNumberCalled;
        this. phoneCallTime = phoneCallTime;
    }

    public void setTelephoneNumberCalled(String telephoneNumberCalled)
    {
        this.telephoneNumberCalled = telephoneNumberCalled;
    }

    public void setPhoneCallTime(int phoneCallTime)
    {
        this.phoneCallTime = phoneCallTime;
    }

    public String getTelephoneNumberCalled()
    {
        return (telephoneNumberCalled);
    }

    public int getPhoneCallTime()
    {
        return (phoneCallTime);
    }
}
