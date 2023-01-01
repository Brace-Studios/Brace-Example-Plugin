package dev.dubhe.brace.example;

import dev.dubhe.brace.BraceServer;
import dev.dubhe.brace.events.brace.CommandRegisterEvent;
import dev.dubhe.brace.example.commands.JrrpCommand;
import dev.dubhe.brace.plugins.Plugin;

public class Example extends Plugin {
    @Override
    public void onInitialization() {
        BraceServer.getEventManager().listen(CommandRegisterEvent.class, event -> event.register(JrrpCommand::register));
    }

    @Override
    public void onUninstall() {

    }
}
