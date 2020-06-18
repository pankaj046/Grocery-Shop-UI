package sharma.pankaj.grocerystore.ui.myorders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.home.adapter.HomeControllerAdapter;
import sharma.pankaj.grocerystore.ui.home.model.ViewModelController;
import sharma.pankaj.grocerystore.ui.myorders.adapter.MyOrderControllerAdapter;
import sharma.pankaj.grocerystore.ui.myorders.model.MyOrderViewControllerModel;

public class MyOrdersFragment extends Fragment {

    @BindView(R.id.order_rv)
    RecyclerView order_rv;
    NavController navController;
    private MyOrderControllerAdapter adapterController;
    private List<MyOrderViewControllerModel> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_orders, container, false);
        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        list.add(new MyOrderViewControllerModel(MyOrderViewControllerModel.ItemType.CURRENT_ORDER_VIEW));
        list.add(new MyOrderViewControllerModel(MyOrderViewControllerModel.ItemType.OLD_ORDER_VIEW));
        adapterController = new MyOrderControllerAdapter(getContext(), list, navController);
        order_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        order_rv.setItemAnimator(new DefaultItemAnimator());
        order_rv.setAdapter(adapterController);
        return root;
    }
}