package net.cosmiclion.domain.domain.login.usecase;

import android.support.annotation.NonNull;

import net.cosmiclion.data.login.TasksDataSource;
import net.cosmiclion.data.login.TasksRepository;
import net.cosmiclion.data.login.model.BaseValueResponse;
import net.cosmiclion.data.utils.Debug;
import net.cosmiclion.domain.domain.UseCase;
import net.cosmiclion.domain.domain.login.model.BaseValue;
import net.cosmiclion.domain.domain.login.model.BaseValueResponseMapper;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by longpham on 9/14/2016.
 */
public class DoGetBaseValue extends UseCase<DoGetBaseValue.RequestValues, DoGetBaseValue.ResponseValue> {
    private final TasksRepository mTasksRepository;

    public DoGetBaseValue(@NonNull TasksRepository tasksRepository) {
        mTasksRepository = checkNotNull(tasksRepository, "tasksRepository cannot be null!");
    }

    @Override
    protected void executeUseCase(final RequestValues requestValues) {

        mTasksRepository.getBaseValueResponse(new TasksDataSource.LoadBaseValueCallback() {
            @Override
            public void onBaseValueLoaded(BaseValueResponse baseValueReponse) {
                getUseCaseCallback().onSuccess(new ResponseValue(baseValueReponse));
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                Debug.i("DoGetBaseValue", "onDataNotAvailable=" + errorMessage);
                getUseCaseCallback().onError();
            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues {
        public RequestValues() {
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        private final BaseValue mBaseValueReponse;

        public ResponseValue(BaseValueResponse baseValueReponse) {
            BaseValue baseValue = BaseValueResponseMapper.transform(baseValueReponse);
            mBaseValueReponse = checkNotNull(baseValue, "mBaseValueReponse cannot null");
        }

        public BaseValue getBaseValueResponse() {
            return mBaseValueReponse;
        }
    }
}
