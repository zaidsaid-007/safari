package com.example.safariguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeeFragment extends Fragment implements AttractionAdapter.OnItemClickListener {

    private List<TouristAttraction> attractionList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homee, container, false);


        // TODO: Implement search functionality here
        attractionList = new ArrayList<>();
        attractionList.add(new TouristAttraction("Amboseli", "Amboseli National Park is a renowned wildlife conservation area located in southern Kenya. It is known for its stunning vistas of Mount Kilimanjaro, Africa's highest peak, which lies just across the border in Tanzania.", R.drawable.ambosslli, 4.5f));
        attractionList.add(new TouristAttraction("Mount Kenya", "Mount Kenya is the highest mountain in Kenya and the second-highest in Africa, after Mount Kilimanjaro. It is a prominent and iconic mountain, known for its stunning beauty and challenging climbing routes. ", R.drawable.mtkenya, 3.2f));
        attractionList.add(new TouristAttraction("Hells Gate", "Through the darkest valleys and fiery paths, we find our way to the light beyond, emerging stronger and wiser, just like Hell's Gate", R.drawable.helsgate, 2.8f));
        attractionList.add(new TouristAttraction("Diani Beach", "Diani Beach is a popular coastal destination located along the Indian Ocean in Kenya. It is known for its stunning white sandy beaches, crystal-clear waters, and a range of activities that cater to both relaxation and adventure.", R.drawable.diani, 3.2f));
        attractionList.add(new TouristAttraction("Masaai Mara", "Maasai Mara, is one of the most famous and popular game reserves in Africa. It is located in southwestern Kenya, contiguous with the Serengeti National Park in Tanzania.", R.drawable.masai, 3.2f));
        attractionList.add(new TouristAttraction("Lake Nakuru", "Lake Nakuru is a shallow, alkaline lake located in the Great Rift Valley of Kenya. It is one of the Rift Valley soda lakes and is renowned for its incredible birdlife, including millions of flamingos that flock to the lake's shores. Here are some key facts about Lake Nakuru:", R.drawable.flamingo, 3.2f));
        attractionList.add(new TouristAttraction("Karura Forest", "The forest offers various recreational activities for visitors, such as walking, jogging, cycling, and picnicking. There are well-maintained trails that lead to scenic spots and waterfalls within the forest..", R.drawable.karura, 3.2f));
        attractionList.add(new TouristAttraction("Lake Victoria", "The lake is one of the main sources of the Nile River. The White Nile, which originates from Lake Victoria, flows out of the lake's northern shore and eventually joins the Blue Nile in Sudan to form the Nile River.", R.drawable.fishing, 3.2f));
        attractionList.add(new TouristAttraction("Fort Jesus", "Fort Jesus was built by the Portuguese between 1593 and 1596, under the orders of King Philip I of Portugal. The primary purpose of the fort was to secure the Portuguese interests in East Africa and protect their trade routes along the Indian Ocean coast.", R.drawable.ftjs, 3.2f));
        attractionList.add(new TouristAttraction("Tsavo National Park", "Tsavo National Park is one of Kenya's most iconic and vast national parks, known for its diverse wildlife, stunning landscapes, and rich natural heritage. It is actually divided into two separate national parks: Tsavo East National Park and Tsavo West National Park. Here are some key facts about each park", R.drawable.tsavo, 3.2f));
        attractionList.add(new TouristAttraction("Ngong Hills", "Tsavo National Park is one of Kenya's most iconic and vast national parks, known for its diverse wildlife, stunning landscapes, and rich natural heritage. It is actually divided into two separate national parks: Tsavo East National Park and Tsavo West National Park. Here are some key facts about each park", R.drawable.tsavo, 3.2f));
        attractionList.add(new TouristAttraction("Lake Bogoria National Reserve", "Lake Bogoria National Reserve in Kenya is renowned for its spectacular birdlife, particularly the abundance of flamingos that lend the alkaline waters a mesmerizing pink hue. Additionally, the reserve's geothermal activity, featuring bubbling hot springs and geysers, adds to its allure, making it a captivating and unique destination for nature enthusiasts and wildlife lovers.", R.drawable.lkbogoria, 3.2f));
        attractionList.add(new TouristAttraction("Mombasa Old Town", "Mombasa Old Town, located in Kenya, holds a rich history as a historic Swahili trading center dating back centuries. It showcases a unique blend of Arab, Indian, and African cultural influences, evident in its architecture, narrow streets, and vibrant markets.", R.drawable.oldport, 4.5f));



        RecyclerView recyclerViewAttractions = view.findViewById(R.id.recyclerViewAttractions);
        // Create and set the adapter for the RecyclerView
        AttractionAdapter adapter = new AttractionAdapter(attractionList, this);
        recyclerViewAttractions.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewAttractions.setAdapter(adapter);

        return view;
    }

    // Handle item click event
    @Override
    public void onItemClick(int position) {
        // Replace this logic with your desired handling for different attractions

        TouristAttraction attraction = attractionList.get(position);
        String attractionName = attraction.getName();
        String attractionDescription = attraction.getDescription();
        int attractionImageResource = attraction.getImageResource();


        Intent intent = null;
        switch (attractionName) {
            case "Amboseli":
                intent = new Intent(getActivity(), Amboseli.class);
                break;
            case "Ngong Hills":
                intent = new Intent(getActivity(), Ngonghills.class);
                break;
            case "Mount Kenya":
                intent = new Intent(getActivity(), Mtkenya.class);
                break;
            case "Hells Gate":
                intent = new Intent(getActivity(), Hellsgate.class);
                break;
            case "Diani Beach":
                intent = new Intent(getActivity(), Diani.class);
                break;
            case "Masaai Mara":
                intent = new Intent(getActivity(), Masaaimara.class);
                break;
            case "Lake Nakuru":
                intent = new Intent(getActivity(), Lknakuru.class);
                break;
            case "Karura Forest":
                intent = new Intent(getActivity(), Karura.class);
                break;
            case "Lake Victoria":
                intent = new Intent(getActivity(), Lkvictoria.class);
                break;
            case "Lake Bogoria National Reserve":
                intent = new Intent(getActivity(), Bogoria.class);
                break;
            case "Fort Jesus":
                intent = new Intent(getActivity(), Fortjesus.class);
                break;
            case "Tsavo National Park":
                intent = new Intent(getActivity(), Tsavo.class);
                break;
            case "Mombasa Old Town":
                intent = new Intent(getActivity(), Msaoldtown.class);
                break;
        }

        if (intent != null) {
            // Add attraction details to the intent (optional)
            intent.putExtra("attractionName", attractionName);
            intent.putExtra("attractionDescription", attractionDescription);
            intent.putExtra("attractionImageResource", attractionImageResource);
            startActivity(intent);
        }
    }
}
