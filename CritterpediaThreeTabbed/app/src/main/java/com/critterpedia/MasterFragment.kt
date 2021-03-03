package com.critterpedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.critterpedia.data.DataSource
import com.critterpedia.helpers.CritterRecyclerAdapter
import com.critterpedia.models.CritterItem
import kotlinx.android.synthetic.main.fragment_master.view.*

class MasterFragment : Fragment(), CritterRecyclerAdapter.OnCritterItemClickListener {

    private lateinit var myCritterAdapter: CritterRecyclerAdapter
    private lateinit var myRecyclerView: RecyclerView
    private val startPosition = 0

    val args by navArgs<MasterFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_master, container, false)

        // Initialize the recycler view
        myCritterAdapter = CritterRecyclerAdapter(this)
        myRecyclerView = rootView.recycler_view
        myRecyclerView.adapter = myCritterAdapter

        // Provide the recycler view with the appropriate data set
        when (args.tabNumber){
            1 -> addFishDataSet()
            2 -> addBugsDataSet()
            3 -> addDeepSeaCreaturesDataSet()
        }

        val isTablet = context?.resources?.getBoolean(R.bool.isTablet) ?: false
        if(isTablet){
            onItemClick(myCritterAdapter.getItem(startPosition), 0)
        }

        return rootView
    }

    /**
     * Traverse to the details page.
     */
    fun openDetail(critterItem: CritterItem){

        val isTablet = context?.resources?.getBoolean(R.bool.isTablet) ?: false
        when{
            //On tablets, replace the detail fragment with a new-arg'd fragment
            //On phones, launch a new detail activity
            isTablet -> swapDetailFragment(critterItem)
//            else -> findNavController().navigate(MasterFragmentDirections.showDetailsFromMaster(args.tabNumber,
//                "I am on a phone",critterItem.name,critterItem.toString(),critterItem.image))
            else -> findNavController().navigate(MasterFragmentDirections.showDetailsFromMaster(args.tabNumber,
                "I am on a phone","critterItem.name",critterItem.toString(),R.drawable.nh_real_anchovy))
        }
    }

    /**
     * Called by openDetail() if in tablet view.
     */
    private fun swapDetailFragment(critterItem: CritterItem) {
        parentFragment?.let {
            val detail = it.fragmentManager?.findFragmentById(R.id.detail_nav_fragment) as NavHostFragment?
            if (detail != null) {
                val navController = detail.navController
                val navInflater = navController.navInflater
                val graph = navInflater.inflate(R.navigation.detail)

                //Override the arguments here with whatever we need to produce this detail fragment
                val forwardedArguments = args.toBundle()

                // Put all item properties in the args (had to be nullable to not crash on tablet)
                forwardedArguments.putString("some_extra_info", "I am on a tablet")
                forwardedArguments.putString("item_name",critterItem.fileName)
                forwardedArguments.putString("item_details",critterItem.toString())
                forwardedArguments.putInt("item_image",R.drawable.appicon) // TODO: get image from url instead of int

                detail.navController.setGraph(graph, forwardedArguments)
            }
        }
    }

    /**
     * On Critter Item Click, open the details about that item.
     */
    override fun onItemClick(critterItem: CritterItem, position: Int) {
        openDetail(critterItem)
    }

    /**
     * Add Fish Data Set from DataSource
     */
    private fun addFishDataSet(){
        val data = DataSource.createFishDataSet()
        myCritterAdapter.submitList(data)
    }

    /**
     * Add Bugs Data Set from DataSource
     */
    private fun addBugsDataSet(){
        val data = DataSource.createBugsDataSet()
        myCritterAdapter.submitList(data)
    }

    /**
     * Add Deep Sea Creatures Data Set from DataSource
     */
    private fun addDeepSeaCreaturesDataSet(){
        val data = DataSource.createDeepSeaCreaturesDataSet()
        myCritterAdapter.submitList(data)
    }

}
