package yourmedicines.processor.exceptions.medicineleaflet;

public class NoParagraphFoundExceptionResponse {

    private String NoParagraphFoundException;

    public NoParagraphFoundExceptionResponse(String noParagraphFoundException) {
        NoParagraphFoundException = noParagraphFoundException;
    }

    public String getNoParagraphFoundException() {
        return NoParagraphFoundException;
    }

    public void setNoParagraphFoundException(String noParagraphFoundException) {
        NoParagraphFoundException = noParagraphFoundException;
    }
}
