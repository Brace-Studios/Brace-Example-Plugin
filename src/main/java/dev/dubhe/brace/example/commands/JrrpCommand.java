package dev.dubhe.brace.example.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import dev.dubhe.brace.base.User;
import dev.dubhe.brace.commands.CommandSourceStack;
import dev.dubhe.brace.commands.Commands;
import dev.dubhe.brace.utils.chat.TextComponent;

import java.util.Calendar;
import java.util.Random;

public class JrrpCommand {
    public static final Random RANDOM = new Random();
    public static final Calendar CALENDAR = Calendar.getInstance();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("jrrp").executes(JrrpCommand::jrrp));
    }

    public static int jrrp(CommandContext<CommandSourceStack> context) {
        int rp = 0;
        CommandSourceStack stack = context.getSource();
        if (stack.getCommandSource() instanceof User user) {
            RANDOM.setSeed(user.getUserID() + CALENDAR.get(Calendar.DATE));
            rp = RANDOM.nextInt(100);
            stack.sendSuccess(new TextComponent(String.valueOf(rp)), false);
        }
        return rp;
    }
}
