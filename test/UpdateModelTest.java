import models.MyModel;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

public class UpdateModelTest {

    @Test
    public void updatingModelShouldWork() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                MyModel m = new MyModel();
                m.name = "Foo";
                m.save();

                List<MyModel> models = MyModel.find.all();
                assertThat(models).hasSize(1);
                assertThat(models.get(0).name).isEqualTo("Foo");

                MyModel savedM = models.get(0);
                savedM.name = "Bar";
                savedM.save();

                List<MyModel> models2 = MyModel.find.all();
                assertThat(models2).hasSize(1);
                assertThat(models2.get(0).name).isEqualTo("Bar");
            }
        });
    }
}
