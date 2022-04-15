package ca.pragmaticcoding.tennis;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;

public class MainController {

    private final MainModel model;
    private final MainViewBuilder viewBuilder;
    private final MainInteractor interactor;

    public MainController() {
        model = new MainModel();
        viewBuilder = new MainViewBuilder(model);
        interactor = new MainInteractor(model);
        loadData();
    }

    private void loadData() {
        Task<Void> loadTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                interactor.loadData();
                return null;
            }
        };
        loadTask.setOnSucceeded(evt -> interactor.loadModel());
        Thread loadThread = new Thread(loadTask);
        loadThread.setDaemon(true);
        loadThread.start();
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
