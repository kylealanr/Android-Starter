package com.appweava.androidstarter.feature;

import com.appweava.androidstarter.base.mvp.BasePresenter;
import com.appweava.androidstarterdomain.feature.MvpData;
import com.appweava.androidstarterdomain.feature.MvpUseCase;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * MvpPresenter
 * <p>
 * Implementation {@link MvpPresenter}. Used as a simple example.
 */
public class MvpPresenter extends BasePresenter<MvpView> {

    private MvpUseCase mvpUseCase;

    @Inject
    public MvpPresenter(MvpUseCase useCase) {
        this.mvpUseCase = useCase;
    }

    @Override
    protected void onViewAttached() {
        // Perform any necessary calls when the view gets attached here.
    }

    @Override
    protected void onViewDetached() {
        unsubCompositeSubscription();
    }

    void getMvpList() {
        subscriptions().add(mvpUseCase.execute(this::onDataReady));
    }

    private void onDataReady(List<MvpData> data) {
        for (MvpData mvpModel : data) {
            Timber.tag("Mvp Activity").i("Model: %s", mvpModel.someField());
        }
    }
}
