import javax.naming.Context;

public class Main {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");

        /*DisappearingElements disappearingElements = new DisappearingElements();
        disappearingElements.checkLists();
        //disappearingElements.repeatTest();

        Digest_Auth digest_auth = new Digest_Auth();
        digest_auth.sendCredentials();

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.contextMenu();

        Checkboxes checkboxes = new Checkboxes();
        checkboxes.firstCheckBox();
        checkboxes.secondCheckBox();

        ChallengingDom cDom = new ChallengingDom();
        cDom.selectFirstRow();

        AddRemoveElement addRemoveElement = new AddRemoveElement();
        addRemoveElement.addButton();
        System.out.println("Add Element Test - DONE");*/

        AddRemoveElement addRemoveElement = new AddRemoveElement();
        addRemoveElement.deleteButton();
        System.out.println("Remove Element Test - DONE");/*

        BasicAuth basicAuth = new BasicAuth();
        basicAuth.correctCredentials();
        basicAuth.wrongCredentials();
        System.out.println("Basic Authentication Test - DONE");

        BrokenImages brokenImages = new BrokenImages();
        brokenImages.checkForBrokenImages();
        System.out.println("Broken Image Test - DONE");*/
    }
}
