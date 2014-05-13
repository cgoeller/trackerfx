package net.goeller.trackerfx.persistence;

import com.thoughtworks.xstream.XStream;
import net.goeller.trackerfx.task.Task;
import net.goeller.trackerfx.task.WorkUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

/**
 * Created by Christian on 12.05.2014.
 */
public class TaskPersister {

    private final Logger log = LoggerFactory.getLogger(TaskPersister.class);
    private final Path file;
    private final XStream xstream;

    public TaskPersister(Path file) {
        this.file = file;
        xstream = new XStream();
        xstream.alias("task", Task.class);
        xstream.alias("workUnit", WorkUnit.class);
        xstream.registerConverter(new DateConverter());
        xstream.addImplicitCollection(Task.class, "workUnits");
    }

    public void save(Collection<Task> tasks) {

        try (OutputStream outputStream = Files.newOutputStream(file)) {
            xstream.toXML(tasks, outputStream);
        } catch (IOException e) {
            log.error("Could not save tasks", e);
        }
    }

    @SuppressWarnings("unchecked")
    public Collection<Task> load() {

        try (InputStream in = Files.newInputStream(file)) {
            Object o = xstream.fromXML(in);
            return (Collection) o;
        } catch (IOException e) {
            log.error("Could not load tasks", e);
        }
        return null;
    }

}
