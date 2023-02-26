package Decorator;

public class DataHandlerdecorator implements DataHandler{
    protected DataHandler dataHandlerToBeDecorated;
    public DataHandlerdecorator (DataHandler dataHandlerToBeDecorated) {
        this.dataHandlerToBeDecorated = dataHandlerToBeDecorated;
    }

    @Override
    public void writeToFile(String file, String data) {
        dataHandlerToBeDecorated.writeToFile(file, data);
    }

    @Override
    public String readFromFile(String file) {
        return dataHandlerToBeDecorated.readFromFile(file);
    }

    public String getDescription() {
        return dataHandlerToBeDecorated.getDescription();
    }
}
