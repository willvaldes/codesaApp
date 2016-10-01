package co.com.codesa.codesaapp.presenters.producto;

import android.app.Activity;

import co.com.codesa.codesaapp.fragments.producto.IProductoView;

/**
 * Created by CODESA on 01/10/2016.
 */

public class ProductoPresenter implements IProductoPresenter {


    private IProductoView view;
    private Activity context;

    public ProductoPresenter(IProductoView view, Activity context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void validarDatos() {

    }
}
