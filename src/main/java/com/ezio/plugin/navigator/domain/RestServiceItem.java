package com.ezio.plugin.navigator.domain;

import com.ezio.plugin.method.HttpMethod;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.module.Module;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/1/13
 */
public class RestServiceItem implements NavigationItem {

    private PsiMethod psiMethod;

    private PsiElement psiElement;

    private Module module;

    private String requestMethod;

    private HttpMethod method;

    private String url;

    private Navigatable navigationElement;

    public RestServiceItem(PsiElement psiElement, String requestMethod, String urlPath) {

        this.psiElement = psiElement;
        if (psiElement instanceof PsiMethod) {
            this.psiMethod = (PsiMethod) psiElement;
        }
        this.requestMethod = requestMethod;
        Optional.ofNullable(requestMethod).ifPresent(e -> {
            this.method = HttpMethod.getByRequestMethod(e);
        });
        this.url = urlPath;
        if (psiElement instanceof Navigatable) {
            navigationElement = (Navigatable) psiElement;
        }
    }


    @Nullable
    @Override
    public String getName() {
        return this.url;
    }

    @Nullable
    @Override
    public ItemPresentation getPresentation() {
        return null;
    }

    @Override
    public void navigate(boolean requestFocus) {

    }

    @Override
    public boolean canNavigate() {
        return false;
    }

    @Override
    public boolean canNavigateToSource() {
        return false;
    }


    public PsiMethod getPsiMethod() {
        return psiMethod;
    }

    public void setPsiMethod(PsiMethod psiMethod) {
        this.psiMethod = psiMethod;
    }

    public PsiElement getPsiElement() {
        return psiElement;
    }

    public void setPsiElement(PsiElement psiElement) {
        this.psiElement = psiElement;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Navigatable getNavigationElement() {
        return navigationElement;
    }

    public void setNavigationElement(Navigatable navigationElement) {
        this.navigationElement = navigationElement;
    }
}
