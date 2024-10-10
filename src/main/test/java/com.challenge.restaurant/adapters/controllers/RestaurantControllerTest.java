@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void testRegisterRestaurantIntegration() throws Exception {
        Restaurant restaurant = new Restaurant("Restaurante A", "Localização A", "Italiana", 50, "11:00 - 23:00");
        when(restaurantService.registerRestaurant(any(Restaurant.class))).thenReturn(restaurant);

        mockMvc.perform(post("/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Restaurante A\", \"location\":\"Localização A\", \"cuisineType\":\"Italiana\", \"capacity\":50, \"openingHours\":\"11:00 - 23:00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Restaurante A"));
    }
}
