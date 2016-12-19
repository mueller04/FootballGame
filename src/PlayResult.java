
public class  PlayResult {

    public enum ResultType {
        TURNOVERONDOWNS,
        FIELDGOALATTEMPT,
        TOUCHDOWN,
        CONTINUE,
        PUNT
    }

    public ResultType currentResultType;

    public void updateResultType(ResultType result) {
        this.currentResultType = result;
    }

}
