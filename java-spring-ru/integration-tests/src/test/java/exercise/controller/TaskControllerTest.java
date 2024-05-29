package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

import java.util.HashMap;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN
    private Task generateTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    @Test
    public void testShowTask() throws Exception {
        var testTask = generateTask();
        taskRepository.save(testTask);
        var result = mockMvc.perform(get("/tasks/" + testTask.getId()))
                .andExpect(status().isOk()).andReturn();

        var body = result.getResponse().getContentAsString();

        assertThatJson(body).and(
                a -> a.node("title").isEqualTo(testTask.getTitle()),
                a -> a.node("description").isEqualTo(testTask.getDescription())
        );
    }

    @Test
    public void testCreate() throws Exception {
        var data = generateTask();

        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isCreated());

        var task = taskRepository.findByTitle(data.getTitle()).get();

        assertThat(task).isNotNull();
        assertThat(task.getTitle()).isEqualTo(data.getTitle());
        assertThat(task.getDescription()).isEqualTo(data.getDescription());
    }

    @Test
    public void testUpdateTask() throws Exception {
        var testTask = generateTask();
        taskRepository.save(testTask);

        var data = new HashMap<>();

        data.put("title", "It's fine");

        var request = put("/tasks/{id}", testTask.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request).andExpect(status().isOk());

        testTask = taskRepository.findById(testTask.getId()).get();

        assertThat(testTask.getTitle()).isEqualTo(data.get("title"));
    }

    @Test
    public void testDeleteTask() throws Exception {
        var testTask = generateTask();
        taskRepository.save(testTask);

        mockMvc.perform(delete("/tasks/{id}", testTask.getId())).andExpect(status().isOk());

        var deletedTask = taskRepository.findByTitle(testTask.getTitle()).orElse(null);
        assertThat(deletedTask).isNull();
    }
    // END
}
