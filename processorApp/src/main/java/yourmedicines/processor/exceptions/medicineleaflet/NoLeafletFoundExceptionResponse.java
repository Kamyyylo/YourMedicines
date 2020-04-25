package yourmedicines.processor.exceptions.medicineleaflet;

public class NoLeafletFoundExceptionResponse {

    private String NoLeafletFoundException;

    public NoLeafletFoundExceptionResponse(String noLeafletFoundException) {
        NoLeafletFoundException = noLeafletFoundException;
    }

    public String getNoLeafletFoundException() {
        return NoLeafletFoundException;
    }

    public void setNoLeafletFoundException(String noLeafletFoundException) {
        NoLeafletFoundException = noLeafletFoundException;
    }
}
