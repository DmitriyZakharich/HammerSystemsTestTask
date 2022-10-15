package com.example.hammersystemstesttask


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.example.hammersystemstesttask.databinding.FragmentMenuBinding
import com.example.hammersystemstesttask.domain.RecyclerMenuAdapter
import com.example.hammersystemstesttask.viewmodel.MenuFragmentViewModel
import com.example.hammersystemstesttask.viewmodel.MenuFragmentViewModelFactory
import com.google.android.material.appbar.CollapsingToolbarLayout
import javax.inject.Inject


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var vmFactory: MenuFragmentViewModelFactory
    private lateinit var viewModel: MenuFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById(R.id.toolbar) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val collToolbar = view.findViewById(R.id.toolbar_layout) as CollapsingToolbarLayout

        viewPagerSetup()
        recyclerViewMenu()
        configuringSpinnerAdapter()
        configuringViewModel()
    }

    private fun configuringViewModel() {
        (requireContext().applicationContext as MyApp).appComponent.inject(this)
        viewModel = ViewModelProvider(this, vmFactory)[MenuFragmentViewModel::class.java]

        (viewModel as MenuFragmentViewModel).adapter.observe(viewLifecycleOwner) {
            binding.recyclerviewMenu.adapter = it
        }
        viewModel.getAdapter()
    }


    private fun configuringSpinnerAdapter() {
        val adapter2 = ArrayAdapter(activity as AppCompatActivity, R.layout.spinner_item, R.id.text1, resources.getStringArray(R.array.cities))
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_item)
        binding.citySpinner.adapter = adapter2
    }

    private fun recyclerViewMenu() {
//        val rvAdapter = RecyclerMenuAdapter(listOf(MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "123", "composition1", "123"),
//            MenuItem(null, "456", "composition2", "456"),
//            MenuItem(null, "678", "composition3", "789")))
//        binding.recyclerviewMenu.adapter = rvAdapter
    }

    private fun viewPagerSetup() {
        val adapter = ViewPagerPromoAdapter(
            listOf(R.drawable.banner1,
                R.drawable.banner2,
                R.drawable.banner3,
                R.drawable.banner4))

        with(binding.viewpagerPromo) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
        binding.viewpagerPromo.setPageTransformer { page, position ->
            val viewPager = page.parent.parent as ViewPager2
            val offset = position * -(2 * offsetPx + pageMarginPx)
            if (viewPager.orientation == ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }
        }

        binding.viewpagerPromo.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = MenuFragment()
    }
}