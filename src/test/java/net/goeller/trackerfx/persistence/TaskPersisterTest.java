package net.goeller.trackerfx.persistence;

import net.goeller.trackerfx.task.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TaskPersisterTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void testSaveAndLoad() throws Exception {

		File f = temporaryFolder.newFile();

		Path p = f.toPath();

		TaskPersister persister = new TaskPersister(p);

		Task t = new Task("asdasd");
		t.setName("testtask");
		t.start();
		t.stop();

		Task t2 = new Task("asdasd");
		t2.start();
		// t2.stop();

		persister.save(Arrays.asList(t, t2));

		List<String> strings = Files.readAllLines(f.toPath());
		for (String line : strings) {
			System.out.println(line);
		}

		Collection<Task> taskList = persister.load();

		System.out.println(taskList.getClass().getName());
		System.out.println(taskList);

	}

}