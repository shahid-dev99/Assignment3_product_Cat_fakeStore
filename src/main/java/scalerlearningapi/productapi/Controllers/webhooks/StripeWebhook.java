package scalerlearningapi.productapi.Controllers.webhooks;

import com.stripe.net.Webhook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks")
public class StripeWebhook {
    @GetMapping
    public void handleWebhook(Webhook webhook){
        System.out.println("webhook Called");

    }
}
