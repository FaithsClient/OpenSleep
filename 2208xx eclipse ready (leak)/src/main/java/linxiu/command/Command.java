/*
 * Decompiled with CFR 0_132.
 */
package linxiu.command;

import linxiu.utils.Helper;

public abstract class Command {
    private final String name;
    protected String[] alias;
    private final String syntax;
    private final String help;
    public static final String chatPrefix = "\u00a7c[\u00a7fA\u00a7c]\u00a77 ";
    
    public Command(String name, String[] alias, String syntax, String help) {
        this.name = name.toLowerCase();
        this.syntax = syntax.toLowerCase();
        this.help = help;
        this.alias = alias;
    }

    public abstract String execute(String[] var1);

    public String getName() {
        return this.name;
    }

    public String[] getAlias() {
        return this.alias;
    }

    public String getSyntax() {
        return this.syntax;
    }

    public String getHelp() {
        return this.help;
    }
    
    public void syntaxError(String msg) {
        Helper.sendMessage(String.format("\u00a77Invalid command usage", msg));
    }

    public void syntaxError(byte errorType) {
        switch (errorType) {
            case 0: {
                this.syntaxError("bad argument");
                break;
            }
            case 1: {
                this.syntaxError("argument gay");
            }
        }
    }
}

