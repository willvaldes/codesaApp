package co.com.codesa.codesaapp.fragments.producto;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTouch;
import co.com.codesa.codesaapp.R;
import co.com.codesa.codesaapp.presenters.producto.IProductoPresenter;
import co.com.codesa.codesaapp.presenters.producto.ProductoPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductoFragment extends Fragment implements IProductoView, DatePickerFragment.OnDialogDatePickerFragmentListener {

    private final int DATE_PICKER_FECHA_VENCIMIENTO = 0;
    private final int DATE_PICKER_FECHA_PRODUCCION=1;

    private IProductoPresenter productoPresenter;

    @Bind(R.id.txtFechVenc)
    EditText txtFechVenc;

    @Bind(R.id.txtFechProd)
    EditText txtFechProd;


    public ProductoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_producto, container, false);
        ButterKnife.bind(this, view);

        productoPresenter= new ProductoPresenter(this, getActivity());


        return view;
    }


    @OnClick(R.id.btnShowDatePickerFechVenc)
    public void showDatePickerFechVenc(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setCallback(this, DATE_PICKER_FECHA_VENCIMIENTO);
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    @OnClick(R.id.btnShowDatePickerFechProd)
    public void showDatePickerFechProd(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setCallback(this, DATE_PICKER_FECHA_PRODUCCION);
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }


    @Override
    public void validarDatos() {

    }

    @Override
    public void onDateSet(int year, int monthOfYear, int dayOfMonth, int requestCode) {

        String fechaText = dayOfMonth + "/" + monthOfYear + "/" + year;

        switch (requestCode){
            case DATE_PICKER_FECHA_VENCIMIENTO:
                txtFechVenc.setText(fechaText);
                break;
            case DATE_PICKER_FECHA_PRODUCCION:
                txtFechProd.setText(fechaText);
                break;

        }


    }
}
