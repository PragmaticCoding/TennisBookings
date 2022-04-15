package ca.pragmaticcoding.widgetsfx;

import ca.pragmaticcoding.widgetsfx.text.Labels;
import ca.pragmaticcoding.widgetsfx.text.Texts;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 * A GridPane with two columns, the left column contains labels (Text items)
 * which are right justified, and the right column contains nodes to
 * display or input data.
 */

public class TwoColumnGridPane extends GridPane {

    public TwoColumnGridPane() {
        ColumnConstraints labelColumn = new ColumnConstraints();
        labelColumn.setHalignment(HPos.RIGHT);
        ColumnConstraints dataColumn = new ColumnConstraints();
        dataColumn.setHalignment(HPos.LEFT);
        getColumnConstraints().add(labelColumn);
        getColumnConstraints().add(dataColumn);
        setHgap(4d);
        setVgap(2d);
        setPadding(new Insets(8d));
    }

    /**
     * Adds a row with text data displayed as a DataText node
     *
     * @param label        the string to put into the label Text
     * @param dataProperty a read only observable string value that is bound to the
     *                     DataText
     * @return the TwoColumnGridPane
     */

    public TwoColumnGridPane addTextRow(String label, ObservableStringValue dataProperty) {
        return addRow(label, Labels.data(dataProperty));
    }

    /**
     * A generic method to add a row with a previously defined data node
     *
     * @param label    the string to put in the label Text
     * @param dataNode the data Node to put in the right column
     * @return the TwoColumnGridPane
     */

    public TwoColumnGridPane addRow(String label, Node dataNode) {
        int row = getRowCount();
        add(Labels.prompt(label), 0, row);
        add(dataNode, 1, row);
        return this;
    }

    /**
     * Adds a row with a TextField for data entry in the right column
     *
     * @param label        the string to put into the label Text
     * @param dataProperty the StringProperty which will be bidirectionally
     *                     bound to the TextField
     * @return the TwoColumnGridPane
     */

    public TwoColumnGridPane addTextFieldRow(String label, StringProperty dataProperty) {
        return addRow(label, Texts.textField(dataProperty));
    }

    /**
     * Adds a row with a DecimalField for data entry in the right column
     *
     * @param label        the string to put into the label Text
     * @param dataProperty the Double property which will be bidirectionally bound to the DecimalField
     * @param maxWidth     the maximum width of the DecimalField
     * @return the TwoColumnGridPane
     */

    public TwoColumnGridPane addDecimalFieldRow(String label, Property<Number> dataProperty, double maxWidth) {
        return addRow(label, Texts.decimalField(dataProperty, maxWidth));
    }

    /**
     * Adds a row with a IntegerField for data entry in the right column
     *
     * @param label        the string to put into the label Text
     * @param dataProperty the Integer property which will be bidirectionally bound to the IntegerField
     * @param maxWidth     the maximum width of the IntegerField
     * @return the TwoColumnGridPane
     */

    public TwoColumnGridPane addIntegerFieldRow(String label, Property<Integer> dataProperty, double maxWidth) {
        return addRow(label, Texts.integerField(dataProperty, maxWidth));
    }

    /**
     * Adds a row with a FixedDecimalField for data entry in the right column
     *
     * @param label        the string to put into the label Text
     * @param dataProperty the Double property which will be bidirectionally bound to the FixedDecimalField
     * @param maxWidth     the maximum width of the FixedDecimalField
     * @return the TwoColumnGridPane
     */

    public TwoColumnGridPane addFixedDecimalFieldRow(String label, Property<Double> dataProperty, int decimalPlaces, double maxWidth) {
        return addRow(label, Texts.fixedDecimalField(dataProperty, decimalPlaces, maxWidth));
    }

    public TwoColumnGridPane addSpinnerRow(String label, Property<Double> dataProperty, double min, double max, double stepSize, double maxWidth) {
        Spinner<Double> dataNode = new Spinner<>(min, max, dataProperty.getValue(), stepSize);
        dataProperty.bind(dataNode.valueProperty());
        dataNode.setMaxWidth(maxWidth);
        return addRow(label, dataNode);
    }

    public TwoColumnGridPane addSpinnerRow(String label, Property<Integer> dataProperty, int min, int max, int stepSize, double maxWidth) {
        Spinner<Integer> dataNode = new Spinner<>(min, max, dataProperty.getValue(), stepSize);
        dataProperty.bind(dataNode.valueProperty());
        dataNode.setMaxWidth(maxWidth);
        return addRow(label, dataNode);
    }
}
