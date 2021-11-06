package tech.anoxsoft.basundharaneighborhood.BloodBank.BloodGroup;

public class BloodModel {
    String donorName;
    String donorLocation;
    String donorPhone;
    String donorAge;
    String donorLastDonation;

    public BloodModel() {
    }

    public BloodModel(String donorName, String donorLocation, String donorPhone,
                      String donorLastDonation, String donorAge) {
        this.donorName = donorName;
        this.donorLocation = donorLocation;
        this.donorPhone = donorPhone;
        this.donorLastDonation = donorLastDonation;
        this.donorAge = donorAge;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorLocation() {
        return donorLocation;
    }

    public void setDonorLocation(String donorLocation) {
        this.donorLocation = donorLocation;
    }

    public String getDonorPhone() {
        return donorPhone;
    }

    public void setDonorPhone(String donorPhone) {
        this.donorPhone = donorPhone;
    }

    public String getDonorLastDonation() {
        return donorLastDonation;
    }

    public void setDonorLastDonation(String donorLastDonation) {
        this.donorLastDonation = donorLastDonation;
    }

    public String getDonorAge() {
        return donorAge;
    }

    public void setDonorAge(String donorAge) {
        this.donorAge = donorAge;
    }
}
