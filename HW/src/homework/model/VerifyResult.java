package homework.model;

public class VerifyResult {
    Boolean isVerifySuccess;
    String id;
    String message;

    public Boolean getVerifySuccess() {
        return isVerifySuccess;
    }

    public void setVerifySuccess(Boolean verifySuccess) {
        isVerifySuccess = verifySuccess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
