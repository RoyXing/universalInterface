package com.xingzy;

import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;

/**
 * @author roy.xing
 * @date 2019/3/6
 */
public class FunctionManager {

    private static String TAG = FunctionManager.class.getSimpleName();

    private static volatile FunctionManager instance;
    private HashMap<String, Function1> noParamNoResult;
    private HashMap<String, Function2> hasParamNoResult;
    private HashMap<String, Function3> noParamHasResult;
    private HashMap<String, Function4> hasParamHasResult;

    private FunctionManager() {
        noParamNoResult = new HashMap<>();
        hasParamNoResult = new HashMap<>();
        noParamHasResult = new HashMap<>();
        hasParamHasResult = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        if (instance == null) {
            instance = new FunctionManager();
        }
        return instance;
    }

    public void registerMethod(Function1 function) {
        noParamNoResult.put(function.functionName, function);
    }

    public void registerMethod(Function2 function) {
        hasParamNoResult.put(function.functionName, function);
    }

    public void registerMethod(Function3 function) {
        noParamHasResult.put(function.functionName, function);
    }

    public void registerMethod(Function4 function) {
        hasParamHasResult.put(function.functionName, function);
    }

    public void invoke(String functionName) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }

        Function1 function1 = noParamNoResult.get(functionName);
        if (function1 != null) {
            function1.function();
        } else {
            Log.e(TAG, functionName + "not found");
        }
    }

    public <P> void invoke(String functionName, P p) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }

        Function2 function1 = hasParamNoResult.get(functionName);
        if (function1 != null) {
            function1.function(p);
        } else {
            Log.e(TAG, functionName + "not found");
        }
    }

    public <T> T invoke(String functionName, Class<T> t) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }

        Function3 function1 = noParamHasResult.get(functionName);
        if (function1 != null) {
            return t.cast(function1.function());
        } else {
            Log.e(TAG, functionName + "not found");
        }
        return null;
    }

    public <T, P> T invoke(String functionName, Class<T> t, P p) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        Function4 function1 = hasParamHasResult.get(functionName);
        if (function1 != null) {
            return t.cast(function1.function(p));
        } else {
            Log.e(TAG, functionName + "not found");
        }
        return null;
    }
}
