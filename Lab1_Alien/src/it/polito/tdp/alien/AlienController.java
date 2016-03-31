package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	private AlienDictionary d= new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lblTesto;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	lblTesto.clear();
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	String riga= lblTesto.getText().toLowerCase();
    	if(riga==null || riga.compareTo("")==0){
    		txtResult.setText("Inserire elementi.");
    		return;
    	}
    	StringTokenizer st= new StringTokenizer(riga, " ");
    	String alien=st.nextToken();
    	if(alien.matches("[a-zA-Z]*")){
    	if(st.hasMoreTokens()){
    		//devo inserire nel dizionario
    		String tr=st.nextToken();
    		if(!tr.matches("[a-zA-Z]*"))
    			txtResult.setText("inserire solo carateeri alfabetici");
    		d.addWord(alien, tr);
    	}
    	else{
    		//devo cercare la traduzione
    		String s=d.translateWord(alien);
    		if (s!=null){
    			txtResult.setText(s);
    		}
    		else { 
    			txtResult.setText("La parola cercata non esiste nel dizionario attualmente");
    		}
    	}
    	}
    	else{
    		if (st.hasMoreElements()) txtResult.setText("Inserire solo caratteri alfabetici");
    		else {
    			String s= d.trovaParoleAssociate(alien);
    			txtResult.setText(s);
    		}
    	}
    }

    @FXML
    void initialize() {
        assert lblTesto != null : "fx:id=\"lblTesto\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
